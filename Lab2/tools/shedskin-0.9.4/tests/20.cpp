#include "builtin.hpp"
#include "20.hpp"

namespace __20__ {


double y;
list<double> *cube;
str *__name__;



void __init() {
    __name__ = new str("__main__");

    cube = (new list<double>());
    cube->append(1.0);
    y = cube->__getfast__(0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__20__::__init);
}
