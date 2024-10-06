#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

/*
Programa que crea un FIFO y lee la información que manda fifoescribe.c
*/
int main(void)
{
    int fp;
    int p;
    char buffer[50]; //El tamaño anterior era muy pequeño, lo aumentamos

    //Crear el FIFO
    p = mkfifo("FIFO2", 0666); //Cambio el mknod ya que buscando en internet leí que está más estandarizado usar mkfifo para crear fifos

    if (p == -1) {
        printf("Ha ocurrido un error.... \n");
        exit(1);
    }

    while (1) {
        //Abrir el FIFO en modo lectura
        fp = open("FIFO2", O_RDONLY); //El parámetro O_RDONLY significa que es solo lectura

        if (fp == -1) {
            printf("Error al abrir el FIFO");
            exit(1);
        }

        //Leer FIFO
        printf("Obteniendo información...\n");

        while (read(fp, buffer, sizeof(buffer)) > 0) {
            printf("%s", buffer);
        }
        
        close(fp);
    }

    return(0);
}