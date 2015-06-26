#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "random.hpp"
#include "code.hpp"
#include "board.hpp"
#include "colour.hpp"
#include "row.hpp"
#include "peg.hpp"
#include "game.hpp"

/**
 * Class Game : Offre les fonctions pour effectuer une partie
 * copyright Sean McCarthy, license GPL v2 or later 
*/

namespace __game__ {

str *__name__;              //nom de la class
class_ *cl_Game;

/**
 * Determine si la partie est finit ou pas selon les regles
 * @return vrai ou faux
 */
__ss_bool Game::isOver() {
    __ss_bool __16, __17;

    if ((this->__tries>0)) {
        return __OR(___bool((this->__tries>=this->__maxguesses)), (this->lastGuess())->equals(this->__secretCode), 16);
    }
    return False;
}

/**
 * Un joueur effectue un essais (on recupere le code proposer)
 * @param guessCode
 * @return 
 */
void *Game::makeGuess(__code__::Code *guessCode) {
    
    this->__tries = (this->__tries+1);
    (this->__board)->addRow((new __row__::Row(guessCode, this->getResult(guessCode))));
    return NULL;
}

/**
 * Recupere le code secret de la partie
 * @return Code secret
 */
__code__::Code *Game::getSecretCode() {
    return this->__secretCode;
}

/**
 * Recupere le nombre d'essais deja effectue
 * @return int > 0
 */
__ss_int Game::getTries() { 
    return this->__tries;
}

/**
 * Determine si le joueur a gagne (trouve le code secret) ou pas
 * @return vrai ou faux
 */
__ss_bool Game::isWon() { 
    return (this->lastGuess())->equals(this->getSecretCode());
}

/**
 * Recupere le derniere essais d'un joueur
 * @return Code devinez
 */
__code__::Code *Game::lastGuess() { 
    return ((this->__board)->getRow((this->__tries-1)))->getGuess();
}

/**
 * Genere le code resultat en fonction ducode devinez et le code secret
 * @param guessCode
 * @return 
 */
__code__::Code *Game::getResult(__code__::Code *guessCode) { 
    return (this->__secretCode)->compare(guessCode);
}

/**
 * Recupere la planche de jeux
 * @return planche de jeux
 */
__board__::Board *Game::getBoard() { 
    return this->__board;
}

/**
 * Recupere le nombre maximal d'essai autoriser pour cette partie
 * @return int > 0
 */
__ss_int Game::getMaxTries() {
    return this->__maxguesses;
}

/**
 * Initialisation d'un jeux
 * @param maxguesses : nombre maximal d'essais
 * @return void
 */
void *Game::__init__(__ss_int maxguesses) {
    __code__::Code *secret;

    secret = (new __code__::Code(NULL));
    secret->setRandomCode((-1));
    this->__secretCode = secret;
    this->__board = (new __board__::Board(1));
    this->__maxguesses = maxguesses;
    this->__tries = 0;
    return NULL;
}

/**
 * Initialisation du namespace
 */
void __init() {
    __name__ = new str("game");
    cl_Game = new class_("Game");
}

} // module namespace

