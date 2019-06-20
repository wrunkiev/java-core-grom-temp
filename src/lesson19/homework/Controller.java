package lesson19.homework;


public class Controller {

    private boolean checkFileFormat(Storage storage, File file){
        for(String format : storage.getFormatsSupported()){
            if(file != null){
                if(file.getFormat().equals(format)){
                    return true;
                }
            }
        }
        return false;
    }

    private long getRealStorageSize(Storage storage){
        long size = 0;
        for(File element : storage.getFiles()){
            if(element != null){
            size += element.getSize();
            }
        }
        return size;
    }

    private boolean checkFileId(Storage storage, File file){
        for(File element : storage.getFiles()){
            if(element != null && file != null) {
                if (file.getId() == element.getId())
                    return false;
            }
        }
        return true;
    }

    public void put(Storage storage, File file) throws Exception{
        if(storage == null)
            throw new NullPointerException("Storage is null.");

        if(file == null)
            throw new NullPointerException("File is null.");

        if(!checkFileFormat(storage, file)){
            throw new Exception("Format of File '" + file.getId() +  "' is not support in Storage '" +
                    storage.getId() + "'.");
        }

        if(getRealStorageSize(storage) + file.getSize() > storage.getStorageSize())
            throw new Exception("Size of Storage '" + storage.getId() + "' is more then valid.");

        if(!checkFileId(storage, file))
            throw new Exception("Storage '" + storage.getId() + "' has File with such ID '" + file.getId() + "'.");

        boolean isFreePlace = false;
        for(int i = 0; i < storage.getFiles().length; i++){
            if(storage.getFiles()[i] == null){
                storage.getFiles()[i] = file;
                isFreePlace = true;
                break;
            }
        }

        if(!isFreePlace)
            throw new Exception("Storage '" + storage.getId() + "' does not free place for File '" + file.getId() + "'.");
    }

    public void delete(Storage storage, File file) throws Exception{
        if(storage == null)
            throw new NullPointerException("Storage is null.");

        if(file == null)
            throw new NullPointerException("File is null.");

        boolean isFile = false;
        for(int i = 0; i < storage.getFiles().length; i++){
            if(storage.getFiles()[i] != null){
                if(storage.getFiles()[i].equals(file)) {
                    storage.getFiles()[i] = null;
                    isFile = true;
                    break;
                }
            }
        }

        if(!isFile)
            throw new Exception("Storage '" + storage.getId() + "' does not have File '" + file.getId() + "'.");
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception{
        for(int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] == null)
                continue;
            if(!checkFileFormat(storageTo, storageFrom.getFiles()[i]))
                throw new Exception("Format of File '" + storageFrom.getFiles()[i].getId() +
                        "' is not support in Storage '" + storageTo.getId() + "'.");
        }

        for(int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] == null)
                continue;
            if(!checkFileId(storageTo, storageFrom.getFiles()[i]))
                throw new Exception("Storage '" + storageTo.getId() + "' has file with such ID: " +
                        storageFrom.getFiles()[i].getId());
        }

        long sizeStorage = getRealStorageSize(storageTo);
        for (int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] != null){
                sizeStorage += storageFrom.getFiles()[i].getSize();
            }
        }
        if(sizeStorage > storageTo.getStorageSize())
            throw new Exception("Size of Storage '" + storageTo.getId() + "' is more then valid.");

        int indexFrom = 0;
        for(File element : storageFrom.getFiles()){
            if(element != null)
                indexFrom++;
        }

        int indexTo = 0;
        for(File element : storageTo.getFiles()){
            if(element == null)
                indexTo++;
        }

        if(indexFrom > indexTo)
            throw new Exception("Count elements in Storage '" + storageTo.getId() + "' are more then valid." );

        for(int i = 0; i < storageFrom.getFiles().length; i++){
            for(int j = 0; j < storageTo.getFiles().length; j++){
                if(storageFrom.getFiles()[i] != null){
                    if(storageTo.getFiles()[j] == null && !storageFrom.getFiles()[i].equals(storageTo.getFiles()[j])){
                        storageTo.getFiles()[j] = storageFrom.getFiles()[i];
                        storageFrom.getFiles()[i] = null;
                    }
                }
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        if(storageFrom == null)
            throw new NullPointerException("StorageFrom is null.");

        if(storageTo == null)
            throw new NullPointerException("StorageTo is null.");

        File findFile = null;
        boolean isFile = false;
        for(File element : storageFrom.getFiles()){
            if(element != null){
                if(element.getId() == id){
                    findFile = element;
                    isFile = true;
                    break;
                }
            }
        }

        if(!isFile)
            throw new Exception("File '" + id + "' is not found in Storage '" + storageFrom.getId() + "'.");

        try{
            put(storageTo, findFile);
            delete(storageFrom, findFile);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
