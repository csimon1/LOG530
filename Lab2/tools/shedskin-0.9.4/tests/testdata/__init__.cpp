#include "builtin.hpp"
#include "stat.hpp"
#include "sys.hpp"
#include "os/path.hpp"
#include "os/__init__.hpp"
#include "testdata/__init__.hpp"
#include "testdata/bert.hpp"

namespace __testdata__ {


str *__name__;



void __init() {
    __name__ = new str("testdata");

}

} // module namespace

