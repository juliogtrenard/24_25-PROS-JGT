#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define TAMANIO 50

int main() {
    int pipe1[2], pipe2[2];
    pid_t pid_hijo, pid_nieto;
    char buffer[TAMANIO];

    //Pipe para la comunicación abuelo -> hijo -> nieto
    if (pipe(pipe1) == -1) {
        printf("Error al crear pipe1");
        exit(-1);
    }

    //Pipe para la comunicación nieto -> hijo -> abuelo
    if (pipe(pipe2) == -1) {
        printf("Error al crear pipe2");
        exit(-1);
    }

    //Crear el proceso hijo
    pid_hijo = fork();
    if (pid_hijo < 0) {
        printf("Error al crear el proceso hijo");
        exit(-1);
    }

    if (pid_hijo == 0) { //Proceso hijo
        close(pipe1[1]); //Cierro escritura de pipe1
        close(pipe2[0]); //Cierro lectura de pipe2

        //Leer mensaje del abuelo
        read(pipe1[0], buffer, TAMANIO);
        printf("    El HIJO recibe mensaje de abuelo: %s\n", buffer);

        //Enviar mensaje al nieto
        char mensaje_hijo[] = "Saludo del padre...";
        printf("    El HIJO envía un mensaje al NIETO...\n");

        //Crear el proceso nieto
        pid_nieto = fork();
        if (pid_nieto < 0) {
            printf("Error al crear el proceso nieto");
            exit(-1);
        }

        if (pid_nieto == 0) { //Proceso nieto
            close(pipe1[0]); //Cierro lectura de pipe1
            close(pipe2[1]); //Cierro escritura de pipe2

            //Recibir mensaje del padre
            read(pipe1[0], buffer, TAMANIO);
            printf("        El NIETO recibe mensaje del padre: %s\n", buffer);

            //Enviar mensaje al hijo
            char mensaje_nieto[] = "Saludo del nieto...";
            printf("        El NIETO envía un mensaje al HIJO...\n");
            write(pipe2[1], mensaje_nieto, strlen(mensaje_nieto));
            exit(0);
        } else {
            //Esperar al nieto
            wait(NULL);

            //Leer mensaje del nieto
            read(pipe2[0], buffer, TAMANIO);
            printf("    El HIJO recibe mensaje de su hijo: %s\n", buffer);

            //Enviar mensaje al abuelo
            char mensaje_hijo_final[] = "Saludo del hijo...";
            printf("    El HIJO envía un mensaje al ABUELO...\n");
            write(pipe2[1], mensaje_hijo_final, strlen(mensaje_hijo_final));
        }

        exit(0);
    } else { //Proceso abuelo
        close(pipe1[0]); //Cierro lectura de pipe1
        close(pipe2[1]); //Cierro escritura de pipe2

        //Enviar mensaje al hijo
        char mensaje_abuelo[] = "Saludo del abuelo...";
        printf("El ABUELO envía un mensaje al HIJO...\n");
        write(pipe1[1], mensaje_abuelo, strlen(mensaje_abuelo));

        wait(NULL); //Esperar al hijo

        //Leer mensaje del hijo
        read(pipe2[0], buffer, TAMANIO);
        printf("El ABUELO recibe mensaje del HIJO: %s\n", buffer);
    }

    exit(0);
}
