SUMMARY = "CY initramfs"
DESCRIPTION = "Embedded Linux initramfs [CY version]"
LICENSE = "MIT"
LIC_FILES_CHKSUM ?= "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Do not pollute the initrd image with rootfs features
IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""

# Set image properties
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "0"

inherit core-image

# Packages to be installed
VIRTUAL-RUNTIME_dev_manager ?= "busybox-mdev"
PACKAGE_INSTALL = " \
	${VIRTUAL-RUNTIME_base-utils} \
	${VIRTUAL-RUNTIME_dev_manager} \
	${ROOTFS_BOOTSTRAP_INSTALL} \
	tiny-initramfs \
"

BAD_RECOMMENDATIONS += "busybox-syslog"
