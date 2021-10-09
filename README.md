## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to run program

Navigate to the bin directory. Run the command `java App ../cookie_data.csv -d 2018-12-09`. The first param is the relative path for the csv data, then the -d param takes in the date for the most active cookie required

## Testing

To test the application, first go to the .vscode hidden directory, click on the settings.json file, and change the `COOKIE_DATA_ABSOLUTE_PATH` env variable to your cookie data absolute path. Then, run the ActiveCookieTest class, preferably in VSCode as this project was built using the IDE. 