#include "builtin.hpp"
#include "44.hpp"

namespace __44__ {


str *__name__;
set<__ss_int> *a;



void __init() {
    __name__ = new str("__main__");

    a = (new set<__ss_int>((new list<__ss_int>(2,1,2))));
    a->add(3);
    print2(NULL,0,1, a);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__44__::__init);
}
