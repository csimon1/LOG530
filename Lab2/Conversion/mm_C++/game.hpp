#ifndef __GAME_HPP
#define __GAME_HPP

using namespace __shedskin__;

namespace __code__ { /* XXX */
    class Code;
}
namespace __board__ { /* XXX */
    class Board;
}
namespace __row__ { /* XXX */
    class Row;
}
namespace __game__ {
    class Game;
    extern str *__name__;
    extern class_ *cl_Game;
    class Game : public pyobj {
    /**
    Class Game, provides functions for playing
    */
    public:
        __ss_int __maxguesses;
        __code__::Code *__secretCode;
        __board__::Board *__board;
        __ss_int __tries;

        Game() {}
        Game(__ss_int maxguesses) {
            this->__class__ = cl_Game;
            __init__(maxguesses);
        }
        __ss_bool isOver();
        void *makeGuess(__code__::Code *guessCode);
        __code__::Code *getSecretCode();
        __ss_int getTries();
        __ss_bool isWon();
        __code__::Code *lastGuess();
        __code__::Code *getResult(__code__::Code *guessCode);
        __board__::Board *getBoard();
        __ss_int getMaxTries();
        void *__init__(__ss_int maxguesses);
    };
    void __init();
} // module namespace
#endif
