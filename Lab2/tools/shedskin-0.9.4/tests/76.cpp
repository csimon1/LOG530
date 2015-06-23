#include "builtin.hpp"
#include "76.hpp"

namespace __76__ {

str *const_0;


list<list<str *> *> *cnf;
str *__name__;



void __init() {
    const_0 = new str("");

    __name__ = new str("__main__");

    cnf = (new list<list<str *> *>(1,(const_0)->split()));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__76__::__init);
}
