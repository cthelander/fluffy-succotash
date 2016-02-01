	.file	"test.mini.s"
	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$12,%esp
	movl	$1,%eax
	movl	%eax,-12(%ebp)
	movl	$15,%eax
	movl	%eax,-8(%ebp)
	movl	$1,%eax
	movl	%eax,-4(%ebp)
	jmp	l1
l0:
	movl	$1,%eax
	movl	-12(%ebp),%ebx
	addl	%ebx,%eax
	movl	-4(%ebp),%ebx
	imull	%ebx,%eax
	movl	%eax,-4(%ebp)
	movl	$1,%eax
	movl	-12(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-12(%ebp)
l1:
	movl	-8(%ebp),%eax
	movl	-12(%ebp),%ebx
	cmpl	%eax,%ebx
	jl	l0
	movl	-4(%ebp),%eax
	pushl	%eax
	call	print
	movl	%ebp,%esp
	popl	%ebp
	ret
