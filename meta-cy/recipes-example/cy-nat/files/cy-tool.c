#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
 
int main(int argc, char *argv[]) {
	const size_t len = sysconf(_SC_PAGESIZE);
	char buf[len], *ptr;
	int nread, nwritten;

	while ((nread = read(STDIN_FILENO, buf, len)) > 0) {
		ptr = buf;
		while (nread > 0) {
			nwritten = write(STDOUT_FILENO, ptr, nread);
			if (nwritten < 0) {
				perror("write:");
				exit(EXIT_FAILURE);
			}
			nread -= nwritten;
			ptr += nwritten;
        	}
	}
	if (nread < 0) {
		perror("read:");
		exit(EXIT_FAILURE);
	}

	return 0;
}
