class Primero extends Thread { 
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Primero " + i);
            try {
                Thread.sleep(100); //100 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}