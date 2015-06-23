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

namespace __game__ {


str *__name__;



/**
 copyright Sean McCarthy, license GPL v2 or later 
*/
class_ *cl_Game;

__ss_bool Game::isOver() {
    __ss_bool __16, __17;

    if ((this->__tries>0)) {
        return __OR(___bool((this->__tries>=this->__maxguesses)), (this->lastGuess())->equals(this->__secretCode), 16);
    }
    return False;
}

void *Game::makeGuess(__code__::Code *guessCode) {
    
    this->__tries = (this->__tries+1);
    (this->__board)->addRow((new __row__::Row(guessCode, this->getResult(guessCode))));
    return NULL;
}

__code__::Code *Game::getSecretCode() {
    
    return this->__secretCode;
}

__ss_int Game::getTries() {
    
    return this->__tries;
}

__ss_bool Game::isWon() {
    
    return (this->lastGuess())->equals(this->getSecretCode());
}

__code__::Code *Game::lastGuess() {
    
    return ((this->__board)->getRow((this->__tries-1)))->getGuess();
}

__code__::Code *Game::getResult(__code__::Code *guessCode) {
    
    return (this->__secretCode)->compare(guessCode);
}

__board__::Board *Game::getBoard() {
    
    return this->__board;
}

__ss_int Game::getMaxTries() {
    
    return this->__maxguesses;
}

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

void __init() {
    __name__ = new str("game");

    /**
     copyright Sean McCarthy, license GPL v2 or later 
    */
    cl_Game = new class_("Game");
}

} // module namespace

