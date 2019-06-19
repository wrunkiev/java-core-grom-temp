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

    public File put(Storage storage, File file){
        if(storage == null)
            return null;

        if(file == null)
            return null;

        if(!checkFileFormat(storage, file))
            return null;

        if(getRealStorageSize(storage) + file.getSize() > storage.getStorageSize())
            return null;

        if(!checkFileId(storage, file))
            return null;


        for(int i = 0; i < storage.getFiles().length; i++){
            if(storage.getFiles()[i] == null){
                storage.getFiles()[i] = file;
                return file;
            }
        }
        return null;
    }

    public void delete(Storage storage, File file){
        /*if(storage == null)
            return null;

        if(file == null)
            return null;*/

        if(storage != null && file != null){
            for(int i = 0; i < storage.getFiles().length; i++){
                if(storage.getFiles()[i].equals(file)) {
                    storage.getFiles()[i] = null;
                    //return file;
                }
            }
        }
        //return null;
    }

    public File[] transferAll(Storage storageFrom, Storage storageTo){
        for(int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] == null)
                continue;
            if(!checkFileFormat(storageTo, storageFrom.getFiles()[i]))
                return null;
        }

        for(int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] == null)
                continue;
            if(!checkFileId(storageTo, storageFrom.getFiles()[i]))
                return null;
        }

        long sizeStorage = getRealStorageSize(storageTo);
        for (int i = 0; i < storageFrom.getFiles().length; i++){
            if(storageFrom.getFiles()[i] != null){
                sizeStorage += storageFrom.getFiles()[i].getSize();
            }
        }
        if(sizeStorage > storageTo.getStorageSize())
            return null;

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
            return null;

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
        return storageTo.getFiles();
    }

    public File transferFile(Storage storageFrom, Storage storageTo, long id){
        File findFile = null;
        for(File element : storageFrom.getFiles()){
            if(element != null){
                if(element.getId() == id){
                    findFile = element;
                }
            }
        }

        put(storageTo, findFile);

        delete(storageFrom, findFile);

        return findFile;
    }
}
