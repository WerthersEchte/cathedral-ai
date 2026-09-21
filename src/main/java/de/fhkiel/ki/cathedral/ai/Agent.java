package de.fhkiel.ki.cathedral.ai;

import de.fhkiel.ki.cathedral.game.Game;
import de.fhkiel.ki.cathedral.game.Placement;
import java.io.PrintStream;
import java.util.Optional;

/**
 * An interface for AI agents to play cathedral
 *
 * @author Eike Petersen {@literal <eike.petersen@fh-kiel.de>}
 * @version 1.2
 * @since 1.0
 */
public interface Agent {

  /**
   * Funktion to name the agent. Will be used when adding the agent to the GUI.
   *
   * @return the name
   */
  default String name(){
    return getClass().getName();
  }

  /**
   * Initializes the agent. Gets the basic game and a Printstream to a GUI-console.
   *
   * @param game    a cathedral game
   * @param console stream to the console
   */
  default void initialize(Game game, PrintStream console){}

  /**
   * Funktion to calculate the agents next action.
   *
   * @param game        the game
   * @param timeForTurn the time for turn
   * @param timeBonus   the time bonus
   * @return the possible Placement in an optional, if optional is empty turn will be passed with no building placed
   */
  Optional<Placement> calculateTurn(Game game, int timeForTurn, int timeBonus);

  /**
   * Called on game end.
   *
   * @param game the game
   */
  default void gameFinished(Game game){}

  /**
   * Asks the agent to stop. Any calculations, etc. should be canceled
   */
  default void stop(){}

}
