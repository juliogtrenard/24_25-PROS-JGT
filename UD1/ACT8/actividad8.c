#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

/*
Programa con procesos Abuelo, hijo y nieto
Se envian mensajes de abuelo -> hijo -> nieto
Como tambien de nieto -> hijo -> abuelo
*/
void main ()
{
    pid_t pidHijo, pidNieto;

    pidHijo = fork();

    switch(pidHijo)
    {
        case -1:
            printf("Error al crear el proceso.");
            exit(-1);
            break;
        case 0:
            //Hijo
            
            pidNieto = fork();
            
            switch(pidNieto)
            {
                case -1:
                    printf("Error al crear el proceso.");
                    exit(-1);
                    break;
                case 0:
                    //Nieto


                    break;
                default:
                    //Hijo


                    break;
            }

            break;
        default:
            //Padre

            break;
    }
}