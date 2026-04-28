SUMMARY = "Home Assistant image"
DESCRIPTION = "A minimal image with Home Assistant"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-ssh-openssh \
    python3-homeassistant \
    systemd \
"

inherit core-image
