#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

/*
 * Lee los datos
 */
int main(void)
{
    int fp, bytesleidos;
    char buffer[10];

    // Se abre el FIFO para leer
    fp = open("FIFO2", O_RDONLY);  // Permiso solo de lectura
    if (fp == -1) {
        perror("Error al abrir FIFO");
        exit(1);
    }

    printf("Obteniendo información...");

    // Se leen los datos que llegan al FIFO
    while (1) {
        bytesleidos = read(fp, buffer, sizeof(buffer) - 1);  // Se leen los bytes
        if (bytesleidos > 0) {
            buffer[bytesleidos] = '\0';  // Asegurar que sea cadena de texto
            printf("%s", buffer);
        } else if (bytesleidos == 0) {
            // Cuando no haya mas datos se cierra
            break;
        } else {
            perror("Error al leer del FIFO");
            break;
        }
    }

    close(fp);
    return 0;
}