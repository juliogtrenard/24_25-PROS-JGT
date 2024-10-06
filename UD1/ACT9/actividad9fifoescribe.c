#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>

/*
Programa con el FIFO que escribe
*/
int main(void)
{
    int fp;
    char saludo[] = "Un saludo !!!!!\n";
    
    //Abrir el FIFO en modo escritura
    fp = open("FIFO2", O_WRONLY); //El parámetro O_WRONLY significa que es solo escritura

    //En caso de error al abrir el FIFO
    if (fp == -1) {
        printf("Error al abrir el fichero... \n");
        exit(1);
    }

    //Escribir en el FIFO y cerrarlo
    printf("Mandando información al FIFO...\n");
    write(fp, saludo, strlen(saludo)); 
    close(fp);

    return(0);
}
