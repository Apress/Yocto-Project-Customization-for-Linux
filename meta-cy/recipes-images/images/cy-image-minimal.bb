SUMMARY = "A small image just capable of allowing a device to boot."
LICENSE = "MIT"

IMAGE_INSTALL = "packagegroup-core-boot"
IMAGE_LINGUAS = " "

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

CURR_DATE = "${@time.strftime('%Y%m%d%H%M%S', time.gmtime())}"
fix_issue() {
    echo "=== CY rootfs IMAGE [${CURR_DATE}] ===\n" >> ${IMAGE_ROOTFS}${sysconfdir}/issue
}
ROOTFS_POSTPROCESS_COMMAND = "fix_issue; "
