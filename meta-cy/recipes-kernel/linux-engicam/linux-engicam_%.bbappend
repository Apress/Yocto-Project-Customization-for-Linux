do_configure:append() {
    for i in ../*.cfg; do
        [ -f "$i" ] || break
        bbdebug 2 "applying $i file contents to .config"
        cat "$i" >> ${B}/.config
    done
}
