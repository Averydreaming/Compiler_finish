@str_0 = global i8* "YES\00"
@str_1 = global i8* "NO\00"
@w_0 = global i32 0
declare void @__builtin_print(i8* %s_0)
declare void @__builtin_println(i8* %s_0)
declare void @__builtin_printInt(i32 %int_0)
declare void @__builtin_printlnInt(i32 %int_0)
declare i32 @__builtin_getInt()
declare i8* @__builtin_getString()
declare i8* @__builtin_toString(i32 %x_0)
declare i8* @__builtin_malloc(i32 %size_0)
declare i8* @__builtin_str_add(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_eq(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_ne(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_gt(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_ge(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_lt(i8* %src1_0, i8* %src2_1)
declare i1 @__builtin_str_le(i8* %src1_0, i8* %src2_1)
declare i32 @__builtin_length(i8* %this_0)
declare i8* @__builtin_substring(i8* %this_0, i32 %left_1, i32 %right_2)
declare i32 @__builtin_parseInt(i8* %this_0)
declare i32 @__builtin_ord(i8* %this_0, i32 %pos_1)
define void @__builtin_init()
{
__builtin_init_0:
	ret 
}
define i32 @main()
{
main_0:
	call @__builtin_init()
	%w_val_1 = load @w_0
	%call_current_val_2 = call @__builtin_getInt()
	store %call_current_val_2, @w_0
	%w_val_1 = load @w_0
	%mod_int_3 = srem %w_val_1, 2
	%eq_bool_4 = cmp eq %mod_int_3, 0
	br %eq_bool_4, main_4, main_6
main_1:
	%string_to_char_7 = get @str_0, 0
	call @__builtin_print(%string_to_char_7)
	jp main_3
main_2:
	%string_to_char_9 = get @str_1, 0
	call @__builtin_print(%string_to_char_9)
	jp main_3
main_3:
	ret 0
main_4:
	%w_val_1 = load @w_0
	%gt_int_6 = cmp sgt %w_val_1, 2
	jp main_7
main_5:
	br %phi_and_5, main_1, main_2
main_6:
	move %phi_and_5, 0
	jp main_5
main_7:
	move %phi_and_5, %gt_int_6
	jp main_5
main_8:
	ret 0
}
