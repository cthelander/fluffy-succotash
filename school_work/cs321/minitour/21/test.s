	.file	"test.s"
	.globl	Main_main
Main_main:
	pushl	%ebp
	movl	%esp,%ebp
	subl	$8,%esp
	movl	$100,%eax
	movl	%eax,-4(%ebp)
	movl	$1,%eax
	movl	%eax,-8(%ebp)
	jmp	l1
l0:
	Div is not yet implemented
	movl	$15,%ebx
	imull	%ebx,%eax
	movl	-8(%ebp),%ebx
	cmpl	%ebx,%eax
	jnz	l2
	movl	$15,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l3
l2:
	Div is not yet implemented
	movl	$5,%ebx
	imull	%ebx,%eax
	movl	-8(%ebp),%ebx
	cmpl	%ebx,%eax
	jnz	l4
	movl	$5,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l5
l4:
	Div is not yet implemented
	movl	$3,%ebx
	imull	%ebx,%eax
	movl	-8(%ebp),%ebx
	cmpl	%ebx,%eax
	jnz	l6
	movl	$3,%eax
	pushl	%eax
	call	print
	addl	$4,%esp
	jmp	l7
l6:
	movl	-8(%ebp),%eax
	movl	%eax,-8(%ebp)
l7:
l5:
l3:
	movl	$1,%eax
	movl	-8(%ebp),%ebx
	addl	%ebx,%eax
	movl	%eax,-8(%ebp)
l1:
	movl	-4(%ebp),%eax
	movl	-8(%ebp),%ebx
	cmpl	%eax,%ebx
	jl	l0
	movl	%ebp,%esp
	popl	%ebp
	ret
