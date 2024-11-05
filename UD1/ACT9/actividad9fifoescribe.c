#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>

/*
 * Envia los datos
 */
int main(void)
{
    int fp;
    char saludo[] = "Un saludo...\n";

    // Se crea el FIFO
    if (mknod("FIFO2", 0100000 | 0666, 0) == -1) {
        perror("Error al crear FIFO");
        exit(1);
    }

    // Se abre el FIFO para escribir
    fp = open("FIFO2", O_WRONLY);  // Permiso solo de escritura
    if (fp == -1) {
        perror("Error al abrir FIFO para escritura");
        exit(1);
    }

    printf("Mandando información al FIFO...\n");

    // Escribimos el mensaje en el FIFO
    if (write(fp, saludo, strlen(saludo)) == -1) {
        perror("Error al escribir en FIFO");
        close(fp);
        exit(1);
    }

    close(fp);
    return 0;
}
