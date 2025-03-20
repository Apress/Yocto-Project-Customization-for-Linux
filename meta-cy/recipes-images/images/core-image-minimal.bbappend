IMAGE_INSTALL:append = " strace"

CURR_DATE = "${@time.strftime('%Y%m%d%H%M%S', time.gmtime())}"
fix_issue() {
    echo "=== CY-version rootfs IMAGE [${CURR_DATE}] ===\n" >> ${IMAGE_ROOTFS}${sysconfdir}/issue
}
ROOTFS_POSTPROCESS_COMMAND = "fix_issue; "
