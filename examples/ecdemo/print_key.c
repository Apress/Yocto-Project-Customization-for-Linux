#include <stdio.h>

#include "key.h"

void print_data(char *label, uint8_t *data)
{
	int i;

	printf("%s ", label);
	for (i = 0; i < SIGN_PUB_KEY_SIZE; i++)
		printf("%02x", data[i]);
	printf("\n");
}

int main(void)
{
	print_data("pub x: ", pub_key_x);
	print_data("pub y: ", pub_key_y);

	return 0;
}
