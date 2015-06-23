#include "builtin.hpp"
#include "55.hpp"

namespace __55__ {


dict<__ss_int, list<double> *> *a;
str *__name__;
list<double> *b;



void __init() {
    __name__ = new str("__main__");

    a = (new dict<__ss_int, list<double> *>());
    (a->setdefault(1, (new list<double>())))->append(1.0);
    b = a->__getitem__(1);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__55__::__init);
}
