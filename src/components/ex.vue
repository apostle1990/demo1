<template>
    <div>
    <canvas id="test" width="480" height="360" style="width: 480px"></canvas>
    <input type="file" id="file" name="file">
    <button type="button" id="green">执行</button>
    <button type="button" id="stop">取消</button>
    </div>
</template>
<script>
const ScratchRender = require('scratch-render/dist/web/scratch-render');
const VirtualMachine = require('scratch-vm/dist/web/scratch-vm');
const ScratchStorage = require('scratch-storage/dist/web/scratch-storage');
const ScratchSVGRenderer = require('scratch-svg-renderer/dist/web/scratch-svg-renderer');
export default {
    mounted(){
        // These variables are going to be available in the "window global" intentionally.
        // Allows you easy access to debug with `vm.greenFlag()` etc.
        window.devicePixelRatio = 1;

        var canvas = document.getElementById('test');
        var render = new ScratchRender(canvas);
        var vm = new VirtualMachine();
        var storage = new ScratchStorage();
        var mockMouse = data => vm.runtime.postIOData('mouse', {
            canvasWidth: canvas.width,
            canvasHeight: canvas.height,
            ...data,
        });
        vm.attachStorage(storage);
        vm.attachRenderer(render);
        vm.attachV2SVGAdapter(new ScratchSVGRenderer.SVGRenderer());
        vm.attachV2BitmapAdapter(new ScratchSVGRenderer.BitmapAdapter());

        document.getElementById('file').addEventListener('change', e => {
            let reader = new FileReader();
            let thisFileInput = e.target;
            reader.onload = () => {
                vm.start();
                vm.loadProject(reader.result)
                    .then(() => {
                        // we add a `#loaded` div to our document, the integration suite
                        // waits for that element to show up to assume the vm is ready
                        // to play!
                        const div = document.createElement('div');
                        div.id = 'loaded';
                        document.body.appendChild(div);
                    });
            };
            reader.readAsArrayBuffer(thisFileInput.files[0]);
        });

        document.getElementById('green').addEventListener('click', e => {
            vm.greenFlag(); // 执行程序
        });
        document.getElementById('stop').addEventListener('click', e => {
            vm.stopAll(); 
        });
    }
}
</script>