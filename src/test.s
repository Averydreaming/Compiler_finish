	.text

	.globl	__builtin_init
	.p2align	2
__builtin_init:
.__builtin_init_0:
	addi	sp, sp, -52
	mv		s0, ra
	sw		s0, 0(sp)
	mv		s0, s0
	sw		s0, 4(sp)
	mv		s0, s1
	sw		s0, 8(sp)
	mv		s0, s2
	sw		s0, 12(sp)
	mv		s0, s3
	sw		s0, 16(sp)
	mv		s0, s4
	sw		s0, 20(sp)
	mv		s0, s5
	sw		s0, 24(sp)
	mv		s0, s6
	sw		s0, 28(sp)
	mv		s0, s7
	sw		s0, 32(sp)
	mv		s0, s8
	sw		s0, 36(sp)
	mv		s0, s9
	sw		s0, 40(sp)
	mv		s0, s10
	sw		s0, 44(sp)
	mv		s0, s11
	sw		s0, 48(sp)
	lw		s0, 0(sp)
	mv		ra, s0
	lw		s0, 4(sp)
	mv		s0, s0
	lw		s0, 8(sp)
	mv		s1, s0
	lw		s0, 12(sp)
	mv		s2, s0
	lw		s0, 16(sp)
	mv		s3, s0
	lw		s0, 20(sp)
	mv		s4, s0
	lw		s0, 24(sp)
	mv		s5, s0
	lw		s0, 28(sp)
	mv		s6, s0
	lw		s0, 32(sp)
	mv		s7, s0
	lw		s0, 36(sp)
	mv		s8, s0
	lw		s0, 40(sp)
	mv		s9, s0
	lw		s0, 44(sp)
	mv		s10, s0
	lw		s0, 48(sp)
	mv		s11, s0
	addi	sp, sp, 52
	ret
	.globl	main
	.p2align	2
main:
.main_0:
	addi	sp, sp, -120
	mv		s0, ra
	sw		s0, 0(sp)
	mv		s0, s0
	sw		s0, 4(sp)
	mv		s0, s1
	sw		s0, 8(sp)
	mv		s0, s2
	sw		s0, 12(sp)
	mv		s0, s3
	sw		s0, 16(sp)
	mv		s0, s4
	sw		s0, 20(sp)
	mv		s0, s5
	sw		s0, 24(sp)
	mv		s0, s6
	sw		s0, 28(sp)
	mv		s0, s7
	sw		s0, 32(sp)
	mv		s0, s8
	sw		s0, 36(sp)
	mv		s0, s9
	sw		s0, 40(sp)
	mv		s0, s10
	sw		s0, 44(sp)
	mv		s0, s11
	sw		s0, 48(sp)
	call	__builtin_init
	la		s0, w
	sw		s0, 52(sp)
	lw		s0, 52(sp)
	lw		s1, 0(s0)
	sw		s1, 56(sp)
	call	__builtin_getInt
	mv		s0, a0
	sw		s0, 60(sp)
	la		s0, w
	sw		s0, 64(sp)
	lw		s0, 60(sp)
	lw		s1, 64(sp)
	sw		s0, 0(s1)
	la		s0, w
	sw		s0, 68(sp)
	lw		s0, 68(sp)
	lw		s1, 0(s0)
	sw		s1, 56(sp)
	addi	s0, zero, 2
	sw		s0, 72(sp)
	lw		s0, 56(sp)
	lw		s1, 72(sp)
	rem	s2, s0, s1
	sw		s2, 76(sp)
	lw		s0, 76(sp)
	addi	s1, s0, 0
	sw		s1, 80(sp)
	lw		s0, 80(sp)
	seqz	s1, s0
	sw		s1, 84(sp)
	lw		s0, 84(sp)
	beqz	s0, .main_6
	j		.main_4
.main_1:
	la		s0, str_0
	sw		s0, 88(sp)
	lw		s0, 88(sp)
	mv		a0, s0
	call	__builtin_print
	mv		s0, a0
	sw		s0, 92(sp)
	j		.main_3
.main_2:
	la		s0, str_1
	sw		s0, 96(sp)
	lw		s0, 96(sp)
	mv		a0, s0
	call	__builtin_print
	mv		s0, a0
	sw		s0, 100(sp)
	j		.main_3
.main_3:
	mv		a0, zero
	lw		s0, 0(sp)
	mv		ra, s0
	lw		s0, 4(sp)
	mv		s0, s0
	lw		s0, 8(sp)
	mv		s1, s0
	lw		s0, 12(sp)
	mv		s2, s0
	lw		s0, 16(sp)
	mv		s3, s0
	lw		s0, 20(sp)
	mv		s4, s0
	lw		s0, 24(sp)
	mv		s5, s0
	lw		s0, 28(sp)
	mv		s6, s0
	lw		s0, 32(sp)
	mv		s7, s0
	lw		s0, 36(sp)
	mv		s8, s0
	lw		s0, 40(sp)
	mv		s9, s0
	lw		s0, 44(sp)
	mv		s10, s0
	lw		s0, 48(sp)
	mv		s11, s0
	addi	sp, sp, 120
	ret
.main_4:
	la		s0, w
	sw		s0, 104(sp)
	lw		s0, 104(sp)
	lw		s1, 0(s0)
	sw		s1, 56(sp)
	addi	s0, zero, 2
	sw		s0, 108(sp)
	lw		s0, 108(sp)
	lw		s1, 56(sp)
	slt	s2, s0, s1
	sw		s2, 112(sp)
	j		.main_7
.main_5:
	lw		s0, 116(sp)
	beqz	s0, .main_2
	j		.main_1
.main_6:
	mv		s0, zero
	sw		s0, 116(sp)
	j		.main_5
.main_7:
	lw		s0, 112(sp)
	mv		s1, s0
	sw		s1, 116(sp)
	j		.main_5
.main_8:
	mv		a0, zero
	lw		s0, 0(sp)
	mv		ra, s0
	lw		s0, 4(sp)
	mv		s0, s0
	lw		s0, 8(sp)
	mv		s1, s0
	lw		s0, 12(sp)
	mv		s2, s0
	lw		s0, 16(sp)
	mv		s3, s0
	lw		s0, 20(sp)
	mv		s4, s0
	lw		s0, 24(sp)
	mv		s5, s0
	lw		s0, 28(sp)
	mv		s6, s0
	lw		s0, 32(sp)
	mv		s7, s0
	lw		s0, 36(sp)
	mv		s8, s0
	lw		s0, 40(sp)
	mv		s9, s0
	lw		s0, 44(sp)
	mv		s10, s0
	lw		s0, 48(sp)
	mv		s11, s0
	addi	sp, sp, 120
	ret

	.section	.sdata,"aw",@progbits
	str_0:
	.asciz	"YES "
	str_1:
	.asciz	"NO "
	.global	w
	.p2align	2
	w:
	.word	0                       # 0
