#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

//Método para manejar la señal que se envía
void manejador(int signal) {
    printf("Padre recibe señal... %d\n", signal);
}

/*
Realiza un programa C en donde un hijo envíe 3 señales SIGUSR1 a su padre y después envíe una señal SIGKILL para que el proceso padre termine.
*/
int main() { 
    int pid_hijo;
    pid_hijo = fork(); //Creamos el hijo

    switch (pid_hijo) {
        case -1: //Error
            printf("No se ha podido crear el proceso hijo...\n");
            exit(-1);
            break;
        case 0: //Proceso hijo
            //Enviar 3 señales SIGUSR1 al padre
            sleep(1);
            for (int i = 0; i < 3; i++) {
                kill(getppid(), SIGUSR1); //Envía señal al padre
                sleep(1); //Espera un segundo entre señales
            }
            kill(getppid(), SIGKILL); //Envía señal SIGKILL al padre
            exit(0);
            break;
        default: //Proceso padre
            signal(SIGUSR1, manejador); //Manejador de señal
            while (1) { //Bucle infinito
                pause(); //Espera a que llegue una señal
            }
    }
    return 0;
}