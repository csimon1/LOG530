#include "builtin.hpp"
#include "18.hpp"

namespace __18__ {


str *__name__;
list<double> *cube;



void __init() {
    __name__ = new str("__main__");

    cube = (new list<double>());
    cube->append(1.0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__18__::__init);
}
