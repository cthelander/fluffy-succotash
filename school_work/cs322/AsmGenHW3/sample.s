	.file	"out.s"

	.data

	.text
	.globl	Xmain
Xmain:
	pushq	%rbp                      # prologue
	movq	%rsp, %rbp
#  	movl	$1, %eax                  # push 1 = local1
#	pushq	%rax        
    pushq	$1        
#	movl	$2, %eax                  # push 2 = local2
#	pushq	%rax    
    pushq	$2    
#	movl	$2, %eax                  # push 2 = local3
#	pushq	%rax	
    pushq	$2	
    jmp	l1
l0:
	movl	$0, %eax                  # push 0 = local4
	pushq	%rax
	jmp	l3
l2:
	movl	-16(%rbp), %edi           # pass local2 as arg1 to f
	movl	-32(%rbp), %esi           # pass local3 as arg2 to f
	call	Xf
	movl	%eax, -16(%rbp)           # save return value of f in to lacal3
	movl	-32(%rbp), %edi           # pass local3 as arg1 to f
	call	Xg
	movq	%rax, %rdi                # pass return value from g as arg1 of h
	call	Xh
	movq	%rax, %rdi
	call	Xprint                    # return value from h
	movl	$1, %eax                    
	movl	-32(%rbp), %edi           
	addl	%edi, %eax                
	movl	%eax, -32(%rbp)           # local4 = local4 + 1
l3:
	movl	-8(%rbp), %eax            # local1
	movl	-32(%rbp), %edi
	cmpl	%eax, %edi                # local4 < local1
	jl	l2
	movl	-16(%rbp), %edi           
	call	Xprint                    # print local2
	movl	-16(%rbp), %eax
	movl	-24(%rbp), %edi
	imull	%edi, %eax                # local2 =  local4 * local2
	movl	%eax, -16(%rbp)           
	movl	-8(%rbp), %eax
    movl	$1, %edi
	addl	%edi, %eax                # local1 = local1 + 1
	movl	%eax, -8(%rbp)
	addq	$8, %rsp                  # move stack pointer
l1:
	movl	$10, %eax
	movl	-8(%rbp), %edi
	cmpl	%eax, %edi                # local1 < 10
	jl	l0
	movl	-8(%rbp), %edi            # print local1
	call	Xprint
	movq	%rbp, %rsp                # epilogue
	popq	%rbp
	ret

	.globl	Xf
Xf:
	pushq	%rbp                      # prologue
	movq	%rsp, %rbp
	movl	%edi, %eax                # arg1
	movl	%esi, %ecx                # arg2
	subl	%ecx, %eax                # arg1 = arg1 - arg2
	pushq	%rax                      # local1 = arg1
	movl	-8(%rbp), %eax          
	pushq	%rax                      # save arguments befor function call
	pushq	%rsi
	pushq	%rdi
	movl	-8(%rbp), %edi            # pass local1 as arg1 to g
	call	Xg
	movq	%rax, %rcx                # g retunr value
	popq	%rdi
	popq	%rsi
	popq	%rax
	imull	%ecx, %eax                # return value of g * local1?
#    movl	%eax, -8(%rbp)
#    movl	-8(%rbp), %eax            # local1
    movq	%rbp, %rsp                # epilogue
    popq	%rbp
	ret

	.globl	Xg
Xg:
	pushq	%rbp                      # prologue
	movq	%rsp, %rbp
	movl	$2, %eax                  # eax = 2
	movl	%edi, %esi                # arg1
	imull	%esi, %eax                # ret = arg1 * 2
	movl	%edi, %esi                # arg1
	subl	%esi, %eax                # ret = ret - arg1
	movq	%rbp, %rsp                # epilogue
	popq	%rbp
	ret

	.globl	Xh
Xh:
	pushq	%rbp                      # prologue
	movq	%rsp, %rbp
	movl	$2, %eax
	movl	%edi, %esi
	cmpl	%eax, %esi                # arg1 < 2
	jnl	l4                            
	movl	$1, %eax                  # return 1
	movq	%rbp, %rsp                # epilogue
	popq	%rbp
	ret
l4:
	pushq	%rdi
	movl	-8(%rbp), %edi            # arg1
#   movl	$1, %esi
	subl	$1, %edi                # arg1 - 1 is arg1 for new call to h
	call	Xh
	popq	%rdi
	pushq	%rax
	pushq	%rdi
	movl	-16(%rbp), %edi 
#	movl	$2, %esi
	subl	$2, %edi                # arg1 - 2 is arg1 for second new call to h
	call	Xh
	movq	%rax, %rsi
	popq	%rdi
	popq	%rax
	addl	%esi, %eax                # return call 1 to h + return call 2 to h
	movq	%rbp, %rsp                # epilogue
	popq	%rbp
	ret

