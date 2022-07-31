# Troubleshooting

## Certain placeholders don't work with '/stats'!
Some placeholders require a player to fetch information. We do not provide a player if the command is being run from the console. Please try to run the command as a player.

## Why does slot #0 keep showing despite none being set in the configuration?
Please read [this](https://7man7lmyt.github.io/CustomStats/configuring/java-menu#adding-more-items) for an explanation on why this happens.

## I can't reload the config!
Make sure you either have OP or have the permission node `customstats.reload`.

## Bedrock players open the Java menu
If you are using Bungeecord/Velocity or another server proxy like the aforementioned, please make sure to have Floodgate installed on all your backend servers properly. A place to find out how to set that up is on the [Floodgate wiki](https://wiki.geysermc.org/floodgate/setup/#installing-floodgate-also-on-spigot-servers-behind-bungeecord-or-velocity).


A good way to check if CustomStats has detected Floodgate is to watch your consone on startup. If you see the following line in your console, that means Floodgate was detected and CustomStats enabled it's floodgate support. *(Note: An identical message shows up when PlaceholderAPI is detected as well.)*
```
[CustomStats] Floodgate detected!
```

## x is not a valid multiple of 9!
This is caused by setting `stats.stat-menu.menu-size` to a number that is not a multiple of 9. Minecraft does not allow creating a menu that is not a multiple of 9.