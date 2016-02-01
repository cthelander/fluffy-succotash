	.file	"out.s"

	.data

	.text
	.globl	_main
_main:
	pushq	%rbp
	movq	%rsp, %rbp
	# Registers: (free = %rax)
	#  %rbx %r12 %r13 %r14 %r15 < > %rax %rdi %r9
	#
	# Pushed on stack: 0
	# Environment:
	#
	movl	$1, %eax
	print	%eax
	movq	%rbp, %rsp
	popq	%rbp
	ret

	.globl	_foo
_foo:
	pushq	%rbp
	movq	%rsp, %rbp
	# Registers: (free = %rax)
	#  %rbx %r12 %r13 %r14 %r15 < %rdi %r9 > %rax
	#
	# Pushed on stack: 0
	# Environment: y->%r9d x->%edi
	#
	movl	%r9d, %eax
	pushq	%rbx
	movl	%edi, %ebx
	addl	%ebx, %eax
	popq	%rbx
	pushq	%rbx
	movl	%r9d, %ebx
	pushq	%r12
	movl	%edi, %r12d
	addl	%r12d, %ebx
	popq	%r12
	addl	%ebx, %eax
	popq	%rbx
	pushq	%rbx
	movl	%r9d, %ebx
	pushq	%r12
	movl	%edi, %r12d
	addl	%r12d, %ebx
	popq	%r12
	pushq	%r12
	movl	%r9d, %r12d
	pushq	%r13
	movl	%edi, %r13d
	addl	%r13d, %r12d
	popq	%r13
	addl	%r12d, %ebx
	popq	%r12
	addl	%ebx, %eax
	popq	%rbx
	print	%eax
	movq	%rbp, %rsp
	popq	%rbp
	ret

