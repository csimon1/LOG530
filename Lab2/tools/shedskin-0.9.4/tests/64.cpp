#include "builtin.hpp"
#include "64.hpp"

namespace __64__ {


list<__ss_int> *a;
str *__name__;



void *dupl(list<__ss_int> *y) {
    list<double> *k;

    k = (new list<double>());
    k->append(1.0);
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    a = (new list<__ss_int>());
    a = (new list<__ss_int>());
    a->append(1);
    dupl(a);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__64__::__init);
}
