#include "builtin.hpp"
#include "69.hpp"

namespace __69__ {


str *__name__;
list<double> *ah;



list<double> *ident(list<double> *x) {
    
    return x;
}

void __init() {
    __name__ = new str("__main__");

    ah = (new list<double>());
    (ident(ah))->append(1.0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__69__::__init);
}
