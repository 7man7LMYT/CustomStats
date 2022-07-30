# Placeholder customization
With CustomStats v2.0.0, CustomStats allows the addition of plugin placeholders through [PlaceholderAPI](https://github.com/PlaceholderAPI/PlaceholderAPI)! Placeholders will work for the main command, the Minecraft: Java Edition menu, and the Minecraft: Bedrock Edition form!

## Built in placeholders

| Placeholder      | What replaces it                       |
|:----------------:|:--------------------------------------:|
|`%totalplayers%`  | Total unique players who have joined   |
|`%onlineplayers%` | Number of currently online players     |

## How to setup placeholders
Setting up placeholders is really simple! Simply take a string from the configuration *Example:*

```yaml
- "&6Total unique players who have joined: 54"
```
Then add the placeholder into the string!
```yaml
- "&6Total unique players who have joined: %totalplayers%"
```

Here's how the change looks in game, before and after!

### Before

![Before change](/CustomStats/img/before.png)

### After

![After change](/CustomStats/img/after.png)

## Want more placeholders?
A list of placeholders supported by PlaceholderAPI can be found [here](https://github.com/PlaceholderAPI/PlaceholderAPI/wiki/Placeholders).