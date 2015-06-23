#ifndef __84_HPP
#define __84_HPP

using namespace __shedskin__;
namespace __84__ {



extern str *__name__;


void *solve_rec();
void *propagate(__ss_int lit, list<__ss_int> *mods, __ss_int bla);
void *lookahead_variable(__ss_int var, list<__ss_int> *mods);

} // module namespace
#endif
