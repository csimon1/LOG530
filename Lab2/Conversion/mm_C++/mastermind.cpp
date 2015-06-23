#include "builtin.hpp"
#include "math.hpp"
#include "time.hpp"
#include "re.hpp"
#include "sys.hpp"
#include "random.hpp"
#include "code.hpp"
#include "board.hpp"
#include "mastermind.hpp"
#include "row.hpp"
#include "colour.hpp"
#include "peg.hpp"
#include "game.hpp"

namespace __mastermind__ {

str *const_0, *const_1, *const_10, *const_11, *const_12, *const_13, *const_14, *const_15, *const_16, *const_17, *const_18, *const_19, *const_2, *const_20, *const_21, *const_22, *const_23, *const_3, *const_4, *const_5, *const_6, *const_7, *const_8, *const_9;


str *__name__;



/**
 copyright Sean McCarthy, license GPL v2 or later 
*/
class_ *cl_Mastermind;

void *Mastermind::play(__ss_int guesses) {
    __game__::Game *gm;

    this->greeting();
    gm = (new __game__::Game(guesses));

    while (__NOT(gm->isOver())) {
        print2(NULL,0,4, const_0, ___box((gm->getTries()+1)), const_1, ___box(gm->getMaxTries()));
        gm->makeGuess(this->__readGuess());
        print2(NULL,0,1, const_2);
        this->display(gm);
        print2(NULL,0,1, const_3);
    }
    if (gm->isWon()) {
        print2(NULL,0,1, const_4);
    }
    else {
        print2(NULL,1,1, const_5);
        this->displaySecret(gm);
    }
    return NULL;
}

void *Mastermind::greeting() {
    
    print2(NULL,0,1, const_6);
    print2(NULL,0,1, const_3);
    print2(NULL,0,1, const_7);
    print2(NULL,0,1, const_3);
    print2(NULL,0,1, const_6);
    print2(NULL,0,1, const_8);
    print2(NULL,0,1, const_9);
    print2(NULL,0,1, const_6);
    return NULL;
}

__code__::Code *Mastermind::__readGuess() {
    list<str *> *__45, *colours;
    __peg__::Peg *peg;
    list<__peg__::Peg *> *guessPegs;
    __ss_bool inputOk;
    __iter<str *> *__46;
    list<str *>::for_in_loop __48;
    str *c;
    __ss_int __47;

    guessPegs = (new list<__peg__::Peg *>());
    print2(NULL,0,1, const_10);
    print2(NULL,0,1, const_11);
    inputOk = False;

    while (__NOT(inputOk)) {
        colours = __re__::split(const_12, raw_input(const_13), 4);

        FOR_IN(c,colours,45,47,48)
            peg = this->__parseColour(c);
            if ((peg!=NULL)) {
                guessPegs->append(peg);
            }
        END_FOR

        inputOk = ___bool((len(guessPegs)==4));
        if (__NOT(inputOk)) {
            print2(NULL,0,1, const_14);
            guessPegs = (new list<__peg__::Peg *>());
        }
    }
    return (new __code__::Code(guessPegs));
}

__peg__::Peg *Mastermind::__parseColour(str *s) {
    
    if ((__re__::search(const_15, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::red));
    }
    else if ((__re__::search(const_16, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::purple));
    }
    else if ((__re__::search(const_17, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::green));
    }
    else if ((__re__::search(const_18, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::yellow));
    }
    else if ((__re__::search(const_19, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::white));
    }
    else if ((__re__::search(const_20, s, 0)!=NULL)) {
        return (new __peg__::Peg(__colour__::Colours::black));
    }
    else {
        return NULL;
    }
    return 0;
}

void *Mastermind::display(__game__::Game *game) {
    list<__row__::Row *> *__21;
    list<__peg__::Peg *>::for_in_loop __30, __36;
    __board__::Board *__26;
    __code__::Code *__32, *__38;
    list<__row__::Row *>::for_in_loop __24;
    list<__peg__::Peg *> *__27, *__33;
    void *__25, *__31, *__37;
    __iter<__peg__::Peg *> *__28, *__34;
    __peg__::Peg *p;
    __ss_int __23, __29, __35;
    __row__::Row *r;
    __iter<__row__::Row *> *__22;


    FOR_IN(r,(game->getBoard())->getRows(),21,23,24)

        FOR_IN(p,(r->getGuess())->getPegs(),27,29,30)
            print2(NULL,1,1, (__str(__colour__::getColourName(p->getColour())))->rjust(6));
        END_FOR

        print2(NULL,1,1, const_21);

        FOR_IN(p,(r->getResult())->getPegs(),33,35,36)
            print2(NULL,1,1, (__str(__colour__::getColourName(p->getColour())))->rjust(6));
        END_FOR

        print2(NULL,0,1, const_6);
    END_FOR

    return NULL;
}

void *Mastermind::displaySecret(__game__::Game *game) {
    list<__peg__::Peg *>::for_in_loop __42;
    list<__peg__::Peg *> *__39;
    __code__::Code *__44;
    void *__43;
    __iter<__peg__::Peg *> *__40;
    __peg__::Peg *p;
    __ss_int __41;


    FOR_IN(p,(game->getSecretCode())->getPegs(),39,41,42)
        print2(NULL,1,1, (__str(__colour__::getColourName(p->getColour())))->rjust(6));
    END_FOR

    return NULL;
}

/**
Instantiate mastermind and invoke play method to play game

*/
void *__ss_main() {
    Mastermind *m;
    __ss_bool __49, __50;
    __ss_int guesses;

    m = (new Mastermind());
    guesses = 8;
    if (((len(__sys__::argv)>1) and (__re__::match(const_22, (__sys__::argv)->__getfast__(1), 0)!=NULL))) {
        guesses = __int((__sys__::argv)->__getfast__(1));
    }
    m->play(guesses);
    return NULL;
}

void __init() {
    const_0 = new str("Guess: ");
    const_1 = __char_cache[47];;
    const_2 = new str("--------Board--------");
    const_3 = new str("---------------------");
    const_4 = new str("Congratulations!");
    const_5 = new str("Secret Code: ");
    const_6 = new str("");
    const_7 = new str("Welcome to Mastermind");
    const_8 = new str("Each guess should be 4 colours from any of:");
    const_9 = new str("red yellow green purple black white");
    const_10 = new str("Type four (space seperated) colours from:");
    const_11 = new str("[r]ed [y]ellow [g]reen [p]urple [b]lack [w]hite");
    const_12 = new str("\\s");
    const_13 = new str("> ");
    const_14 = new str("Invalid input, use colours as stated");
    const_15 = new str("^r");
    const_16 = new str("^p");
    const_17 = new str("^g");
    const_18 = new str("^y");
    const_19 = new str("^w");
    const_20 = new str("^b");
    const_21 = new str(" | Result:\t");
    const_22 = new str("\\d");
    const_23 = new str("__main__");

    __name__ = new str("__main__");

    /**
     copyright Sean McCarthy, license GPL v2 or later 
    */
    cl_Mastermind = new class_("Mastermind");
    /**
    Instantiate mastermind and invoke play method to play game
    
    */
    if (__eq(__name__, const_23)) {
        __ss_main();
    }
}

} // module namespace

int main(int __ss_argc, char **__ss_argv) {
    __shedskin__::__init();
    __math__::__init();
    __time__::__init();
    __random__::__init();
    __colour__::__init();
    __peg__::__init();
    __code__::__init();
    __row__::__init();
    __board__::__init();
    __game__::__init();
    __re__::__init();
    __sys__::__init(__ss_argc, __ss_argv);
    __shedskin__::__start(__mastermind__::__init);
}
