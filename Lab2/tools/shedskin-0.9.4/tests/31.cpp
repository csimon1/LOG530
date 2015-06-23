#include "builtin.hpp"
#include "31.hpp"

namespace __31__ {


list<__ss_int> *puzzlecolumns;
str *__name__;



void __init() {
    __name__ = new str("__main__");

    puzzlecolumns = (new list<__ss_int>(1,1));
    print2(NULL,0,1, ___box(puzzlecolumns->__len__()));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__31__::__init);
}
