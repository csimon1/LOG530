#ifndef __37_HPP
#define __37_HPP

using namespace __shedskin__;
namespace __37__ {

extern str *const_0, *const_1, *const_10, *const_2, *const_3, *const_4, *const_5, *const_6, *const_7, *const_8, *const_9;


typedef __ss_int (*lambda0)(__ss_int, __ss_int);

extern __iter<list<__ss_int> *> *__23;
extern list<__ss_int> *__26, *clause, *fixedt, *lit_mask, *vars;
extern __ss_int __24, __28, bincount, global_mask, hoppa, lit, nodecount, nrofvars, part_mask, propcount, some_failure;
extern list<list<__ss_int> *> *__22, *clauses;
extern list<list<str *> *> *cnf;
extern __iter<__ss_int> *__27;
extern str *__name__;
extern list<list<list<__ss_int> *> *> *occurrence;
extern list<str *> *argv;


__ss_int _reduce(lambda0 f, list<__ss_int> *l, __ss_int i);
__ss_int solve_rec();
__ss_int propagate(__ss_int lit, list<__ss_int> *mods, __ss_int failed_literal);
void *mask_propagate(__ss_int lit);
void *mask_binclause(list<__ss_int> *lits);
__ss_int lookahead(list<__ss_int> *mods);
__ss_int lookahead_variable(__ss_int var, list<__ss_int> *mods, list<__ss_int> *dif);
__ss_int backtrack(list<__ss_int> *mods);
tuple2<__ss_int, __ss_int> *info(list<__ss_int> *clause);
list<__ss_int> *unfixed_vars();
list<__ss_int> *unfixed_lits(list<__ss_int> *clause);

} // module namespace
#endif
