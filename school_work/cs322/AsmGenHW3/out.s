	.file	"out.s"

	.data
Xx:
	.long	0

	.text
	.globl	XinitGlobals
XinitGlobals:
	pushq	%rbp
	movq	%rsp, %rbp
	movl	$0, %eax
	movl	%eax, Xx
	movq	%rbp, %rsp
	popq	%rbp
	ret

	.globl	Xmain
Xmain:
	pushq	%rbp
	movq	%rsp, %rbp
	movl	$0, %eax
	pushq	%rax
	movl	$1, %eax
	pushq	%rax
	movl	$1, %eax
	pushq	%rax
	jmp	l1
l0:
	movl	-8(%rbp), %edi
	call	Xprint
	movl	-8(%rbp), %eax
	movl	$1, %edi
	addl	%edi, %eax
	movl	%eax, -8(%rbp)
	movl	-16(%rbp), %eax
	movl	-8(%rbp), %edi
	imull	%edi, %eax
	movl	%eax, -16(%rbp)
	movl	-24(%rbp), %eax
	movl	$2, %edi
	imull	%edi, %eax
	movl	%eax, -24(%rbp)
l1:
	movl	$10, %eax
	movl	-8(%rbp), %edi
	cmpl	%eax, %edi
	jl	l0
	movl	-24(%rbp), %edi
	call	Xprint
	movl	-16(%rbp), %edi
	call	Xprint
	movq	%rbp, %rsp
	popq	%rbp
	ret

