import Checkers.BufferedR;
import Checkers.FileReadWithFiles;
import Checkers.FileReaderClass;

class Main {
    static void main(String[] args) {
        FileReaderClass fl = new FileReaderClass();
        fl.File_Reader();


        BufferedR bf = new BufferedR();
        bf.BuffReader();

        FileReadWithFiles frl = new FileReadWithFiles();
        frl.readWholeFile();
    }
}