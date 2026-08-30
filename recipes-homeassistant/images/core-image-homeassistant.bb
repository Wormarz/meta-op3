SUMMARY = "Home Assistant image"
DESCRIPTION = "A minimal image with Home Assistant"

IMAGE_FEATURES += "ssh-server-openssh"

# Networking (standalone, no NetworkManager):
# - wpa-supplicant: wifi auth, cf. wpa_supplicant_%.bbappend (enables
#   wpa_supplicant@wlan0 + default wlan0 conf) -> usable via wpa_cli.
# - iw: wireless tools. wireless-regdb-static: regulatory.db for kernel>=4.15
#   (the plain wireless-regdb package only ships legacy crda regulatory.bin).
# - dhcpcd: automatic IP on every interface.
IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    python3-homeassistant \
    systemd \
    \
    wpa-supplicant \
    iw \
    wireless-regdb-static \
    dhcpcd \
"

inherit core-image
