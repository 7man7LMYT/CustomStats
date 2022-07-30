# Customizing the default command

*Note: This page applies to the default `/stats` command. For customizing everything else, use either the [bedrock form](https://7man7lmyt.github.io/CustomStats/configuring/bedrock-form) or [java menu](https://7man7lmyt.github.io/CustomStats/configuring/java-menu) pages instead.*

## Default command configuration
```yaml
stat-command:
  - "&a-----------------------------------------------------"
  - "&6This server was created on July 30, 2022."
  - "&6The world is 12.34GB in size."
  - "&6Over %totalplayers% players have joined since."
  - "&a-----------------------------------------------------"
```

## Adding more lines
Adding more lines to the command relies on following the same format in the config. Placeholders are supported here, as well as the usage of the `&` and `§` symbols for color codes.