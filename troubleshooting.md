# Troubleshooting

## I can't reload the config!
Make sure you are OP'ed, or have the permission node `customstats.reload`.

## Bedrock players open the Java menu
If you are using Bungeecord/Velocity or another server proxy, please make sure to have Floodgate installed on all your backend servers properly. A place to find out how to set that up is on the [Floodgate wiki](https://wiki.geysermc.org/floodgate/setup/#installing-floodgate-also-on-spigot-servers-behind-bungeecord-or-velocity).


A good way to check if CustomStats has detected Floodgate is to watch your consone on startup. If you see the following line in your console, that means Floodgate was detected and CustomStats enabled it's floodgate support.
```
[CustomStats] Floodgate detected!
```

## x is not a valid multiple of 9!
This is caused by setting `stats.stat-menu.menu-size` to a number that is not a multiple of 9. Minecraft does not allow creating a menu that is not a multiple of 9.