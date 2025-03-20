#define pr_fmt(fmt) "%s:%s: " fmt, KBUILD_MODNAME, __func__
#include <linux/module.h>

static int __init khello_init(void)
{
	pr_info("khello loaded\n");
	return 0;
}

static void __exit khello_exit(void)
{
	pr_info("khello unloaded\n");
}

module_init(khello_init);
module_exit(khello_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Rodolfo Giometti <giometti@enneenne.com>");
MODULE_DESCRIPTION("khello: example kernel module");
