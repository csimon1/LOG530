#ifndef __MASTERMIND_HPP
#define __MASTERMIND_HPP

using namespace __shedskin__;

namespace __code__ { /* XXX */
    class Code;
}
namespace __board__ { /* XXX */
    class Board;
}
namespace __peg__ { /* XXX */
    class Peg;
}
namespace __game__ { /* XXX */
    class Game;
}
namespace __row__ { /* XXX */
    class Row;
}
namespace __mastermind__ {
    extern str *const_0, *const_1, *const_10, *const_11, *const_12, *const_13, *const_14, *const_15, *const_16, *const_17, *const_18, *const_19, *const_2, *const_20, *const_21, *const_22, *const_23, *const_3, *const_4, *const_5, *const_6, *const_7, *const_8, *const_9;
    class Mastermind;
    extern str *__name__;
    extern class_ *cl_Mastermind;
    class Mastermind : public pyobj {
    /**
    The game of Mastermind

    This class provides a function "play" for invoking a new game.

    The objective of the game is to guess a code composed of 4 coloured
    pegs. The code can be composed of any combination of the six colours
    (red, green, purple, yellow, white, black), and can include duplicates.

    For each guess a result code may be returned composed of black and/or
    white pegs. A black peg indicates a peg of the right colour and in the
    right position. A white peg indicates a peg of the right colour but in
    the wrong position. The arrangement of the pegs does not correspond to
    the pegs in the guess- black pegs will always be shown first, followed
    but white pegs.

    The game ends with either a correct guess or after running out of 
    guesses.
    */
    public:

        Mastermind() { this->__class__ = cl_Mastermind; }
        void *play(__ss_int guesses);
        void *greeting();
        __code__::Code *__readGuess();
        __peg__::Peg *__parseColour(str *s);
        void *display(__game__::Game *game);
        void *displaySecret(__game__::Game *game);
    };

    void *__ss_main();
} // module namespace
#endif
