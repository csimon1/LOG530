#include "builtin.hpp"
#include "60.hpp"

namespace __60__ {


str *__name__;



void __init() {
    __name__ = new str("__main__");

}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__60__::__init);
}
