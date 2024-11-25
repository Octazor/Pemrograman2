package soal1;
import java.util.Random;

class Dice {
    private int nilai;

    public Dice(){
        acaknilai();
    }

    public void acaknilai() {
        Random random = new Random();
        this.nilai = random.nextInt(6) + 1;
    }

    public int getNilai() {
        return nilai;
    }
}

