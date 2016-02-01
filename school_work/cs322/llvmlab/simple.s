	.file	"simple.ll"
	.text
	.globl	Xmain
	.align	16, 0x90
	.type	Xmain,@function
Xmain:                                  # @Xmain
	.cfi_startproc
# BB#0:                                 # %entre
	pushq	%rax
.Ltmp1:
	.cfi_def_cfa_offset 16
	movl	$33, %eax
	addl	$22, %eax
	movl	%eax, %edi
	callq	Xprint
	popq	%rax
	ret
.Ltmp2:
	.size	Xmain, .Ltmp2-Xmain
	.cfi_endproc

	.globl	XinitGlobals
	.align	16, 0x90
	.type	XinitGlobals,@function
XinitGlobals:                           # @XinitGlobals
	.cfi_startproc
# BB#0:                                 # %entry
	ret
.Ltmp3:
	.size	XinitGlobals, .Ltmp3-XinitGlobals
	.cfi_endproc


	.section	".note.GNU-stack","",@progbits
