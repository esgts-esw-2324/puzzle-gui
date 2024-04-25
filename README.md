# Puzzle GUI

This project provides a GUI built with Java Swing for a puzzle.

The actual implementation for the game is not in this library, you have to implement it yourself, in order to do that you must provide an implementation for the `IBoard` interface.

```java
package pt.brunojesus.puzzle;

/**
 * Interface to be used for the {@link GameWindow}
 * 
 * @author Bruno Jesus
 * @since 1.0
 * @version 1.0
 */
public interface IBoard {

	/**
	 * Gets the size of the board
	 *
	 * @return the board size
	 */
	int getSize();

	/**
	 * Executes a play and the desired position relative to the empty slot
	 *
	 * @throws Exception if play is invalid
	 */
	void play(PlayDirection direction) throws Exception;

	/**
	 * Gets the item in position.
	 *
	 * @param x the x coordinate, from 0 to {@link this.getSize()}
	 * @param y the y coordinate, from 0 to {@link this.getSize()}
	 * @return the item in position: "1"..."N" or <b>""</b> if it doesn't exist.
	 */
	String getItemInPosition(int x, int y);
}
```

With a board implementation done, getting the GUI can be accomplished just by
instantiating it:
```java
public class Application {
    public static void main(String[] args) {
        IBoard board = new Board();
        new GameWindow(board);
    }
}
```

## Installing

Add `mvn.brunojesus.pt` repository to your project's `pom.xml` `<distributionManagement>` section:

```xml
<distributionManagement>
    <repository>
        <id>mvn-brunojesus</id>
        <name>Bruno Jesus MVN Repo</name>
        <url>https://mvn.brunojesus.pt/releases</url>
    </repository>
</distributionManagement>
```

Add the dependency to your project under `<dependencies>`:

```xml
<dependencies>
    <dependency>
        <groupId>pt.brunojesus</groupId>
        <artifactId>puzzle-gui</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```
